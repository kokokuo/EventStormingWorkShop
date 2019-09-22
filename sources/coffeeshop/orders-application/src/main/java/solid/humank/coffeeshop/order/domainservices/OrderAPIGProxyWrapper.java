package solid.humank.coffeeshop.order.domainservices;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import solid.humank.coffeeshop.order.datacontracts.results.OrderTicket;
import solid.humank.coffeeshop.order.commands.CreateOrder;

public class OrderAPIGProxyWrapper implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Yes oh my !!! Loading Java Lambda handler of ProxyIntegration mode \r\n");
        logger.log(apiGatewayProxyRequestEvent.getBody());

        CreateOrder createOrder = ProxyRequestEventTranslator.translate(apiGatewayProxyRequestEvent);

        OrderTicket orderTicket = DomainRegistry.orderService().establishOrder(createOrder);

        APIGatewayProxyResponseEvent responseEvent = ProxyResponseWrapper.wrap(orderTicket);
        

        return responseEvent;
    }
}
