package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.*;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.exitcode.ExitCode;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Callback;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xinquan.huangxq
 */
public class LotusChainAPITest extends AbstractLotusAPITest {

    private final LotusChainAPI lotusChainAPI = lotusAPIFactory.createLotusChainAPI();

    private final LotusStateAPI lotusStateAPI = lotusAPIFactory.createLotusStateAPI();

    @Test
    public void head() throws IOException {
        Response<TipSet> response = lotusChainAPI.head().execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void asyncHead() throws IOException, InterruptedException {
        CountDownLatch cdl = new CountDownLatch(1);
        lotusChainAPI.head().enqueue(new Callback<TipSet>() {
            @Override
            public void onResponse(Call<TipSet> call, Response<TipSet> response) {
                Assert.assertNotNull(response.getResult());

                cdl.countDown();
            }

            @Override
            public void onFailure(Call<TipSet> call, Throwable t) {
                t.printStackTrace(System.err);
            }
        });
        cdl.await();
    }

    @Test
    public void getGenesis() throws IOException {
        Response<TipSet> response = lotusChainAPI.getGenesis().execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getBlock() throws IOException {
        Response<BlockHeader> response = lotusChainAPI.getBlock(Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc")).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getTipSet() throws IOException {
        TipSetKey tipSetKey = TipSetKey.of("bafy2bzacec2qt5iuro25nmrt25amfb3lx6nebtdmdljodcuzen36lxrkjk2o4",
                "bafy2bzacecy5go5sxv7rgm5ncd5zkgwm43rhg7ko35rue5jh52jliym55ofrg",
                "bafy2bzacebkqspb5auphn5dxucsdmc7xsnj6pcxjhc7ivlxsla6oxlhniwkq6");

        Response<TipSet> response = lotusChainAPI.getTipSet(tipSetKey).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getBlockMessages() throws IOException {
        Cid blockCid = Cid.of("bafy2bzacebine7gvzfm4kejk6qoolspcrnqpoanwqjcj5qlhgp3japt74q2sc");

        Response<BlockMessages> response = lotusChainAPI.getBlockMessages(blockCid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getParentReceipts() throws IOException {
        Cid blockCid = Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc");

        Response<List<MessageReceipt>> response = lotusChainAPI.getParentReceipts(blockCid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getParentMessages() throws IOException {
        Cid blockCid = Cid.of("bafy2bzacechdndwv3k6zripfpxm4jtwdvqnzlp6uvldccwf6cycmd2w3elvfc");

        Response<List<Message>> response = lotusChainAPI.getParentMessages(blockCid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getMessage() throws IOException {
        Cid cid = Cid.of("bafy2bzacebgzuqqkjtgauyg5f4wdgnovlyfzrlc67fjjmgxontek3unpu2fse");

        Response<com.github.mufanh.filecoin4j.domain.types.Message> response = lotusChainAPI.getMessage(cid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getTipSetByHeight() throws IOException {
        TipSetKey tsk = TipSetKey.of("bafy2bzacec2qt5iuro25nmrt25amfb3lx6nebtdmdljodcuzen36lxrkjk2o4",
                "bafy2bzacecy5go5sxv7rgm5ncd5zkgwm43rhg7ko35rue5jh52jliym55ofrg",
                "bafy2bzacebkqspb5auphn5dxucsdmc7xsnj6pcxjhc7ivlxsla6oxlhniwkq6");

        Response<TipSet> response1 = lotusChainAPI.getTipSetByHeight(445113L, tsk).execute();
        Assert.assertNotNull(response1.getResult());

        Response<TipSet> response2 = lotusChainAPI.getTipSetByHeight(445113L, null).execute();
        Assert.assertNotNull(response2.getResult());

        Response<TipSet> response3 = lotusChainAPI.getTipSetByHeight(null, tsk).execute();
        Assert.assertNotNull(response3.getResult());
    }

    @Test
    public void getMessagesByHeight() throws ExecutionException, InterruptedException {
        List<com.github.mufanh.filecoin4j.domain.types.Message> messages
                = getMessagesFutureByHeight(456906L).get();
    }

    private CompletableFuture<List<com.github.mufanh.filecoin4j.domain.types.Message>> getMessagesFutureByHeight(long height) {
        // 根据固定高度拉去TipSet
        CompletableFuture<TipSet> tipSetFuture = call(() -> lotusChainAPI.getTipSetByHeight(height, null));
        // 获取所有状态OK的消息
        return tipSetFuture.thenCompose((ts) -> {
            // 获取当前高度的区块
            List<Cid> blockCids = ts.getCids();
            // 获取每个区块的消息列表
            CompletableFuture<?>[] futureArray =
                    blockCids.stream()
                            .map((blockCid) -> call(() -> lotusChainAPI.getBlockMessages(blockCid)))
                            .toArray(CompletableFuture<?>[]::new);
            CompletableFuture<Void> future = CompletableFuture.allOf(futureArray);
            return future.thenApply(v -> Stream.of(futureArray)
                    .map(CompletableFuture::join)
                    .map(e -> (BlockMessages) e)
                    .flatMap(e -> Stream.concat(e.getBlsMessages().stream(),
                            e.getSecpkMessages().stream().map(SignedMessage::getMessage)))
                    .filter(distinctByKey(com.github.mufanh.filecoin4j.domain.types.Message::getCid)) // 去重
                    .collect(Collectors.toList()));
        });
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private static <T> CompletableFuture<T> call(Supplier<Call<T>> call) {
        CompletableFuture<T> result = new CompletableFuture<>();
        call.get().enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response == null
                        || response.getRawResponse() == null
                        || !response.getRawResponse().isSuccessful()) {
                    result.completeExceptionally(new IOException("执行Lotus API调用异常，本次处理失败"));
                    return;
                }
                result.complete(response.getResult());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                result.completeExceptionally(new IOException("执行Lotus API调用异常，本次处理失败", t));
            }
        });
        return result;
    }
}