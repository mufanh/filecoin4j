package com.github.mufanh.filecoin4j.rpc;

import com.github.mufanh.filecoin4j.domain.InvocResult;
import com.github.mufanh.filecoin4j.domain.Message;
import com.github.mufanh.filecoin4j.domain.MessageMatch;
import com.github.mufanh.filecoin4j.domain.MinerPower;
import com.github.mufanh.filecoin4j.domain.MsgLookup;
import com.github.mufanh.filecoin4j.domain.builtin.MinerInfo;
import com.github.mufanh.filecoin4j.domain.builtin.SectorOnChainInfo;
import com.github.mufanh.filecoin4j.domain.cid.Cid;
import com.github.mufanh.filecoin4j.domain.types.*;
import com.github.mufanh.jsonrpc4j.Call;
import com.github.mufanh.jsonrpc4j.Callback;
import com.github.mufanh.jsonrpc4j.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xinquan.huangxq
 */
public class LotusStateAPITest extends AbstractLotusAPITest {

    private final LotusStateAPI lotusStateAPI = lotusAPIFactory.createLotusStateAPI();

    private final LotusChainAPI lotusChainAPI = lotusAPIFactory.createLotusChainAPI();

    @Test
    public void call() throws IOException {
    }

    @Test
    public void replay() throws IOException {
        TipSetKey tsk = null;
        Response<InvocResult> response = lotusStateAPI.replay(
                tsk, Cid.of("bafy2bzaceaq46krmjsgvndbj5euj7pykinsyoi33nd7enasr4anymz3ve4lfw")).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void searchMsg() throws IOException {
        Cid cid = Cid.of("bafy2bzaceaq46krmjsgvndbj5euj7pykinsyoi33nd7enasr4anymz3ve4lfw");

        Response<MsgLookup> response = lotusStateAPI.searchMsg(cid).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void getActor() throws IOException {
        String address = "f01248";

        Response<Actor> response = lotusStateAPI.getActor(address, null).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void minerInfo() throws IOException {
        String address = "f01248";

        Response<MinerInfo> response = lotusStateAPI.minerInfo(address, null).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void minerPower() throws IOException {
        String address = "f01248";

        Response<MinerPower> response = lotusStateAPI.minerPower(address, null).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void sectorGetInfo() throws IOException {
        String address = "f01248";

        Response<SectorOnChainInfo> response = lotusStateAPI.sectorGetInfo(address, 1L, null).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void minerActiveSectors() throws IOException {
        String address = "f01248";

        Response<List<SectorOnChainInfo>> response = lotusStateAPI.minerActiveSectors(address, null).execute();
        Assert.assertNotNull(response.getResult());
    }

    @Test
    public void listMessages() throws IOException {
        MessageMatch messageMatch = MessageMatch.of(
                "f3uxabcz2sudm4wyjosmtulk7p3yvy3dwbfi4lhgwzoflfdjzrasbriziyiz7hqonshtlfqhvlhyzgzm7i6noa",
                null);
        // 6907的tsk
        TipSetKey tsk = TipSetKey.of("bafy2bzacebine7gvzfm4kejk6qoolspcrnqpoanwqjcj5qlhgp3japt74q2sc",
                "bafy2bzacebfmegqd4yvqzxfbuxs7fbuuwklf5qmierzyhr3mhmlxmxhphk5du",
                "bafy2bzacebhevfzjiqo4mj2ls22e6orcmw3hmeysqizutuhi6q3gxn2cizvxw",
                "bafy2bzaceb2hgjqsdj5nbpfngjq6g7lcjhdoydx56rlodjwfcflvx3qxdfyce");
        Response<List<Cid>> response = lotusStateAPI.listMessages(messageMatch, tsk, 456906L).execute();
        Assert.assertNotNull(response.getResult());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void listMessagesByHeight2() throws IOException {
        long currentHeight = 456906L;
        CompletableFuture<TipSet> tipSetFuture = call(() -> lotusChainAPI.getTipSetByHeight(currentHeight, null));
        CompletableFuture<List<Message>> messagesFuture = tipSetFuture.thenCompose((ts) -> {
            // blockCid
            List<Cid> cidList = ts.getBlocks()
                    .stream()
                    .findFirst()
                    .get()
                    .getParents();
            System.out.println(cidList);

           /* // 每个都返回List<Message> 其实随便选一个cidList获取的消息一样，因为这些cidList对应的parent一致
            CompletableFuture<?>[] futureArray = cidList.stream()
                    .map((cid) -> call(() -> lotusChainAPI.getParentMessages(cid)))
                    .toArray(CompletableFuture<?>[]::new);
            CompletableFuture<Void> future = CompletableFuture.allOf(futureArray);
            // 返回所有block的List<Message>
            return future.thenApply(v -> Stream.of(futureArray)
                    .map((e) -> (List<Message>) e.join())
                    .peek(System.out::println)
                    .flatMap(e -> e.stream())
                    .collect(Collectors.toList()));*/
            return call(() -> lotusChainAPI.getParentMessages(cidList.get(0)));
        });
        /*CompletableFuture<List<MsgLookup>> lookupsFuture = messagesFuture.thenCompose((messages) -> {
            CompletableFuture<?>[] futureArray = messages.stream()
                    .map(Message::getCid)
                    .map((cid) -> call(() -> lotusStateAPI.searchMsg(cid)))
                    .toArray(CompletableFuture<?>[]::new);
            CompletableFuture<Void> future = CompletableFuture.allOf(futureArray);
            return future.thenApply(v -> Stream.of(futureArray)
                    .map((e) -> (CompletableFuture<MsgLookup>) e)
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList()));
        });
        Assert.assertNotNull(lookupsFuture.join());
        */

        List<Message> messages = messagesFuture.join();
        Assert.assertNotNull(messages);

        CompletableFuture<MsgLookup> msgLookupFuture = call(() -> lotusStateAPI.searchMsg(messages.get(0).getCid()));
        Assert.assertNotNull(msgLookupFuture.join());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void listMessagesByHeight() throws IOException {
        long currentHeight = 456906L;
        MessageMatch messageMatch = MessageMatch.of(
                "f3uxabcz2sudm4wyjosmtulk7p3yvy3dwbfi4lhgwzoflfdjzrasbriziyiz7hqonshtlfqhvlhyzgzm7i6noa",
                null);

        CompletableFuture<TipSet> tipSetFuture = call(() -> lotusChainAPI.getTipSetByHeight(currentHeight, null));
        CompletableFuture<List<InvocResult>> resultFuture = tipSetFuture.thenCompose((ts) -> {
            TipSetKey tsk = TipSetKey.of(ts.getCids());
            CompletableFuture<List<Cid>> cidListFuture = call(() -> lotusStateAPI.listMessages(
                    messageMatch, tsk, currentHeight));
            return cidListFuture.thenCompose((cidList) -> {
                CompletableFuture<?>[] futureArray = cidList.stream()
                        .map((cid) -> call(() -> lotusStateAPI.replay(tsk, cid)))
                        .toArray(CompletableFuture<?>[]::new);
                CompletableFuture<Void> future = CompletableFuture.allOf(futureArray);
                return future.thenApply(v -> Stream.of(futureArray)
                        .map((e) -> (CompletableFuture<InvocResult>) e)
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
            });
        });
        List<InvocResult> result = resultFuture.join();
        Assert.assertNotNull(result);
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