package com.coin58.api.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.coin58.api.client.ApiRestClient;
import com.coin58.api.client.domain.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementation of 58coin's REST API using Retrofit with synchronous/blocking method calls.
 */
public class ApiRestClientImpl implements ApiRestClient {

    private final ApiService apiService;

    public ApiRestClientImpl(String apiKey, String secret) {
        apiService = ApiServiceGenerator.createService(ApiService.class, apiKey, secret);
    }

    public JSONObject transfer(String currencyName, Integer triggerSiteId, Integer targetSiteId, String amount) {
        return ApiServiceGenerator.executeSync(apiService.transfer(currencyName, triggerSiteId, targetSiteId, amount));
    }

    @Override
    public List<AssetsResponse> getAssets(int siteId) {
        return ApiServiceGenerator.executeSync(apiService.getAssets(12));
    }

    @Override
    public List<Contract> getContractList() {
        return ApiServiceGenerator.executeSync(apiService.getContractList());
    }

    @Override
    public List<SettlementResponse> getSettlementList() {
        return ApiServiceGenerator.executeSync(apiService.getSettlementList());
    }

    @Override
    public List<KlineResponse> getKline(String product, String type, long since) {
        return ApiServiceGenerator.executeSync(apiService.getKline(product, type, since));
    }

    @Override
    public TickerResponse getTicker(long contraceId) {
        return ApiServiceGenerator.executeSync(apiService.getTickerList(contraceId));
    }

    @Override
    public DepthResponse getDepth(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.getDepth(contractId));
    }

    @Override
    public AssetResponse getAsset(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.getAsset(contractId));
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        return ApiServiceGenerator.executeSync(apiService.newOrder(order.getContractId(), order.getOrderType().getCode(), order.getSide().getCode(), order.getLeverage(), order.getSize(),
                order.getPrice(), order.getCloseType().getCode()));
    }

    @Override
    public JSONObject cancelOrder(long orderId, long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelOrder(orderId, contractId));
    }

    @Override
    public JSONObject cancelOrderBatch(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelOrderBatch(contractId));
    }

    @Override
    public JSONObject closeAll(long contractId) {
        return ApiServiceGenerator.executeSync(apiService.closeAll(contractId));
    }

    @Override
    public List<OrderListResponse> getOrderList(long contractId, Integer side, Integer close) {
        return ApiServiceGenerator.executeSync(apiService.getOrderList(contractId, side, close));
    }

    @Override
    public List<FillListResponse> getFillList(long contractId, Integer close, Integer limit) {
        return ApiServiceGenerator.executeSync(apiService.getFillList(contractId, close, limit));
    }

    @Override
    public JSONObject getPositionList(long contractId) {
        return ApiServiceGenerator.executeSync(apiService.getPositionList(contractId));
    }

    @Override
    public JSONObject newPlanOrder(NewPlanOrder planOrder) {
        return ApiServiceGenerator.executeSync(
                apiService.newPlanOrder(planOrder.getContractId(), planOrder.getSide(), planOrder.getTriggerPrice(), planOrder.getSize(), planOrder.getMode(), planOrder.getType(), planOrder.getPrice()));
    }

    @Override
    public JSONObject cancelPlan(long contractId, long planId) {
        return ApiServiceGenerator.executeSync(apiService.cancelPlan(contractId, planId));
    }

    @Override
    public JSONObject cancelPlanBatch(Long contractId) {
        return ApiServiceGenerator.executeSync(apiService.cancelPlanBatch(contractId));
    }

    @Override
    public List<PlanListResponse> getPlanList(long contractId, Integer limit) {
        return ApiServiceGenerator.executeSync(apiService.getPlanList(contractId, limit));
    }

    @Override
    public JSONObject getWallet() {
        return ApiServiceGenerator.executeSync(apiService.getWallet());
    }

    @Override
    public JSONObject accountTransfer(long contractId, long action, BigDecimal amount) {
        return ApiServiceGenerator.executeSync(apiService.accountTransfer(contractId, action, amount));
    }
}