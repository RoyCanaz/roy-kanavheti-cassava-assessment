package com.econetwireless.epay.business.utils;

import com.econetwireless.epay.domain.SubscriberRequest;
import com.econetwireless.in.webservice.CreditRequest;
import com.econetwireless.in.webservice.CreditResponse;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.pojo.INBalanceResponse;
import org.apache.commons.lang3.StringUtils;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.*;

public class TestUtility {
    public static final Answer<SubscriberRequest> SUBSCRIBER_REQUEST = invocationOnMock -> {
        Object[] arguments = invocationOnMock.getArguments();
        if (arguments != null && arguments.length > 0) {
            SubscriberRequest request = (SubscriberRequest) arguments[0];
            if (request == null) {
                return null;
            }
            if (request.getId() == null) {
                request.setId(new Random().nextLong());
            }
            if (request.getDateCreated() == null) {
                request.setDateCreated(new Date());
            }
            request.setDateLastUpdated(new Date());
            return request;
        }
        return null;
    };
    public final static Answer<INBalanceResponse> SUCCESSFUL_BALANCE_ENQUIRY = invocationOnMock -> {
        Object[] arguments = invocationOnMock.getArguments();
        if (arguments != null && arguments.length > 1) {
            String partnerCode = (String) arguments[0];
            String msisdn = (String) arguments[1];
            INBalanceResponse balanceResponse = new INBalanceResponse();
            if (StringUtils.isEmpty(partnerCode)) {
                balanceResponse.setResponseCode(ResponseCode.INVALID_REQUEST.getCode());
                balanceResponse.setNarrative("Invalid request, missing partner code");
                return balanceResponse;
            }
            if (StringUtils.isEmpty(msisdn)) {
                balanceResponse.setResponseCode(ResponseCode.INVALID_REQUEST.getCode());
                balanceResponse.setNarrative("Invalid request, missing mobile number");
                return balanceResponse;
            }
            balanceResponse.setMsisdn(msisdn);
            balanceResponse.setAmount(100);
            balanceResponse.setNarrative("Successful balance enquiry");
            balanceResponse.setResponseCode(ResponseCode.SUCCESS.getCode());
            return balanceResponse;
        }
        return null;
    };


    public static List<SubscriberRequest> SUBSCRIBER_REQUESTS = new ArrayList<>();

    static {
        List<String> partners = new ArrayList<>(Arrays.asList("A", "B", "C", "C", "D"));
        partners.forEach((partner) -> {
            SubscriberRequest request = new SubscriberRequest();
            request.setDateLastUpdated(new Date());
            request.setDateCreated(new Date());
            request.setId(new Random().nextLong());
            request.setPartnerCode(partner);
            request.setBalanceAfter(new Random().nextDouble());
            request.setBalanceBefore(new Random().nextDouble());
            request.setAmount(new Random().nextDouble());
            SUBSCRIBER_REQUESTS.add(request);
        });

    }


}
