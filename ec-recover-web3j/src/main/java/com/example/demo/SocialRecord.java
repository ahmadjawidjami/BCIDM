package com.example.demo;

import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.0.1.
 */
public final class SocialRecord extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b60008054600160a060020a03191633600160a060020a031690811782556040805160808101825260078183019081527f43726561746f720000000000000000000000000000000000000000000000000060608301528152600160208083018290529385528352922082518051919261008a928492909101906100ac565b50602091909101516001909101805460ff19169115159190911790555b61014c565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100ed57805160ff191683800117855561011a565b8280016001018555821561011a579182015b8281111561011a5782518255916020019190600101906100ff565b5b5061012792915061012b565b5090565b61014991905b808211156101275760008155600101610131565b5090565b90565b611020806200015c6000396000f300606060405236156100755763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b581146100775780634b733d0f146100895780636383cc201461017d57806393a1122e1461029c578063c57411a814610306578063d3b493b314610425575bfe5b341561007f57fe5b6100876104fb565b005b341561009157fe5b610161600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375050604080516020601f818a01358b0180359182018390048302840183018552818452989a60ff8b35169a90999401975091955091820193509150819084018382808284375050604080516020601f89358b0180359182018390048302840183019094528083529799988101979196509182019450925082915084018382808284375094965061052895505050505050565b60408051600160a060020a039092168252519081900360200190f35b341561018557fe5b610210600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375050604080516020601f89358b018035918201839004830284018301909452808352979998810197919650918201945092508291508401838280828437509496506105a595505050505050565b6040805183151581526020808201838152845193830193909352835191929160608401918501908083838215610261575b80518252602083111561026157601f199092019160209182019101610241565b505050905090810190601f16801561028d5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b34156102a457fe5b6102f2600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375094965061087a95505050505050565b604080519115158252519081900360200190f35b341561030e57fe5b610210600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284375050604080516020601f89358b0180359182018390048302840183019094528083529799988101979196509182019450925082915084018382808284375094965061093195505050505050565b6040805183151581526020808201838152845193830193909352835191929160608401918501908083838215610261575b80518252602083111561026157601f199092019160209182019101610241565b505050905090810190601f16801561028d5780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b341561042d57fe5b61047b600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650610d8b95505050505050565b6040805160208082528351818301528351919283929083019185019080838382156104c1575b8051825260208311156104c157601f1990920191602091820191016104a1565b505050905090810190601f1680156104ed5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60005433600160a060020a039081169116146105175760006000fd5b600054600160a060020a0316ff5b5b565b60208481015183820151838301516040805160008181528187018352908201819052815185815260ff8a16818801528083018590526060810184905291519095600192608080820193601f1981019281900390910190898661646e5a03f1151561058e57fe5b50506020604051035193505b505050949350505050565b60006105af610efa565b6002846040518082805190602001908083835b602083106105e15780518252601f1990920191602091820191016105c2565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff1615915061063490505750506040805160208101909152600080825290610873565b604060405190810160405280848152602001600115158152506002856040518082805190602001908083835b6020831061067f5780518252601f199092019160209182019101610660565b51815160209384036101000a60001901801990921691161790529201948552506040519384900381019093208451805191946106c094508593500190610f0c565b506020918201516001918201805460ff191691151591909117905560408051808201825287815280840183905233600160a060020a03166000908152928452912081518051929391926107169284920190610f0c565b5060208201518160010160006101000a81548160ff0219169083151502179055509050507f28ba1e13b3c31eb411f244a6e1b269965b606b4befb99d94517174a24957c52b3385856040518084600160a060020a0316600160a060020a0316815260200180602001806020018381038352858181518152602001915080519060200190808383600083146107c5575b8051825260208311156107c557601f1990920191602091820191016107a5565b505050905090810190601f1680156107f15780820380516001836020036101000a031916815260200191505b5083810382528451815284516020918201918601908083838215610830575b80518252602083111561083057601f199092019160209182019101610810565b505050905090810190601f16801561085c5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a15060019050815b9250929050565b60006002826040518082805190602001908083835b602083106108ae5780518252601f19909201916020918201910161088f565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092209150600090506108e98282610f8b565b506001908101805460ff19169055600160a060020a0333166000908152602091909152604081209061091b8282610f8b565b506001908101805460ff1916905590505b919050565b600061093b610efa565b836040518082805190602001908083835b6020831061096b5780518252601f19909201916020918201910161094c565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020600019166001600033600160a060020a0316600160a060020a031681526020019081526020016000206000016040518082805460018160011615610100020316600290048015610a1f5780601f106109fd576101008083540402835291820191610a1f565b820191906000526020600020905b815481529060010190602001808311610a0b575b5050915050604051809103902060001916141515610ac5576000608060405190810160405280606081526020017f54686973206163636f756e74206973206e6f7420616c6c6f77656420746f206d81526020017f6f646966792074686520736f6369616c207265636f726420636f72726573706f81526020017f6e64696e6720746f207468652073706563696669656420676c6f62616c20696481525091509150610873565b6002846040518082805190602001908083835b60208310610af75780518252601f199092019160209182019101610ad8565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff1615159150610b9b9050576000606060405190810160405280602981526020017f5468652073706563696669656420736f6369616c207265636f726420646f657381526020017f6e2774206578697374000000000000000000000000000000000000000000000081525091509150610873565b604060405190810160405280848152602001600115158152506002856040518082805190602001908083835b60208310610be65780518252601f199092019160209182019101610bc7565b51815160209384036101000a6000190180199092169116179052920194855250604051938490038101909320845180519194610c2794508593500190610f0c565b5060208201518160010160006101000a81548160ff0219169083151502179055509050507fcccdb45f3b5672bf7d1d195ebd44389811a7e68c2a0aa29a9d25cbd1eb2853d73385856040518084600160a060020a0316600160a060020a0316815260200180602001806020018381038352858181518152602001915080519060200190808383600083146107c5575b8051825260208311156107c557601f1990920191602091820191016107a5565b505050905090810190601f1680156107f15780820380516001836020036101000a031916815260200191505b5083810382528451815284516020918201918601908083838215610830575b80518252602083111561083057601f199092019160209182019101610810565b505050905090810190601f16801561085c5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a15060019050815b9250929050565b610d93610efa565b6002826040518082805190602001908083835b60208310610dc55780518252601f199092019160209182019101610da6565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092206001015460ff1615159150610e0790505760006000fd5b6002826040518082805190602001908083835b60208310610e395780518252601f199092019160209182019101610e1a565b518151600019602094850361010090810a820192831692199390931691909117909252949092019687526040805197889003820188208054601f6002600183161590980290950116959095049283018290048202880182019052818752929450925050830182828015610eed5780601f10610ec257610100808354040283529160200191610eed565b820191906000526020600020905b815481529060010190602001808311610ed057829003601f168201915b505050505090505b919050565b60408051602081019091526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610f4d57805160ff1916838001178555610f7a565b82800160010185558215610f7a579182015b82811115610f7a578251825591602001919060010190610f5f565b5b50610f87929150610fd3565b5090565b50805460018160011615610100020316600290046000825580601f10610fb15750610fcf565b601f016020900490600052602060002090810190610fcf9190610fd3565b5b50565b610ff191905b80821115610f875760008155600101610fd9565b5090565b905600a165627a7a723058203097cb796e2270904e649c0025f1795168528faf39476aaff79f252ead6c6e6b0029";

    private SocialRecord(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private SocialRecord(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<SocialRecordAddedEventResponse> getSocialRecordAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SocialRecordAdded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<SocialRecordAddedEventResponse> responses = new ArrayList<SocialRecordAddedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            SocialRecordAddedEventResponse typedResponse = new SocialRecordAddedEventResponse();
            typedResponse.user = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
            typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SocialRecordAddedEventResponse> socialRecordAddedEventObservable() {
        final Event event = new Event("SocialRecordAdded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SocialRecordAddedEventResponse>() {
            @Override
            public SocialRecordAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SocialRecordAddedEventResponse typedResponse = new SocialRecordAddedEventResponse();
                typedResponse.user = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
                typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<SocialRecordUpdatedEventResponse> getSocialRecordUpdatedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SocialRecordUpdated", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<SocialRecordUpdatedEventResponse> responses = new ArrayList<SocialRecordUpdatedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            SocialRecordUpdatedEventResponse typedResponse = new SocialRecordUpdatedEventResponse();
            typedResponse.updater = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
            typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SocialRecordUpdatedEventResponse> socialRecordUpdatedEventObservable() {
        final Event event = new Event("SocialRecordUpdated", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SocialRecordUpdatedEventResponse>() {
            @Override
            public SocialRecordUpdatedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SocialRecordUpdatedEventResponse typedResponse = new SocialRecordUpdatedEventResponse();
                typedResponse.updater = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
                typedResponse.socialRecordString = (Utf8String)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<SocialReocordDeletedEventResponse> getSocialReocordDeletedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SocialReocordDeleted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<SocialReocordDeletedEventResponse> responses = new ArrayList<SocialReocordDeletedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            SocialReocordDeletedEventResponse typedResponse = new SocialReocordDeletedEventResponse();
            typedResponse.deleter = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SocialReocordDeletedEventResponse> socialReocordDeletedEventObservable() {
        final Event event = new Event("SocialReocordDeleted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SocialReocordDeletedEventResponse>() {
            @Override
            public SocialReocordDeletedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                SocialReocordDeletedEventResponse typedResponse = new SocialReocordDeletedEventResponse();
                typedResponse.deleter = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.globalId = (Utf8String)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> verify(Utf8String _hash, Uint8 _v, Utf8String _r, Utf8String _s) {
        Function function = new Function("verify", Arrays.<Type>asList(_hash, _v, _r, _s), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> addSocialRecord(Utf8String _globalId, Utf8String _socialRecordString) {
        Function function = new Function("addSocialRecord", Arrays.<Type>asList(_globalId, _socialRecordString), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> deleteSocialRecord(Utf8String _globalId) {
        Function function = new Function("deleteSocialRecord", Arrays.<Type>asList(_globalId), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> updateSocialRecord(Utf8String _globalId, Utf8String _socialRecordString) {
        Function function = new Function("updateSocialRecord", Arrays.<Type>asList(_globalId, _socialRecordString), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Utf8String> getSocialRecord(Utf8String _globalId) {
        Function function = new Function("getSocialRecord", 
                Arrays.<Type>asList(_globalId), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<SocialRecord> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(SocialRecord.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static Future<SocialRecord> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(SocialRecord.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static SocialRecord load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SocialRecord(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static SocialRecord load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SocialRecord(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class SocialRecordAddedEventResponse {
        public Address user;

        public Utf8String globalId;

        public Utf8String socialRecordString;
    }

    public static class SocialRecordUpdatedEventResponse {
        public Address updater;

        public Utf8String globalId;

        public Utf8String socialRecordString;
    }

    public static class SocialReocordDeletedEventResponse {
        public Address deleter;

        public Utf8String globalId;
    }
}
