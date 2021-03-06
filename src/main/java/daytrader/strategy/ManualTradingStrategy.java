package daytrader.strategy;

import com.lmax.api.FixedPointNumber;
import com.lmax.api.order.Order;
import com.lmax.api.orderbook.OrderBookEvent;
import daytrader.DayTrader;
import daytrader.enums.TradeSide;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ManualTradingStrategy implements ITradingStrategy {


    private final DayTrader dayTrader;
    private Map<Long, String> trades;


    public ManualTradingStrategy(DayTrader dayTrader) {
        this.dayTrader = dayTrader;
        this.trades = new HashMap<Long, String>();
    }

    @Override
    public void handlePriceEvent(OrderBookEvent event) {


    }

    @Override
    public void handleTradeEvent(Order orderId) {

    }

    @Override
    public void handleUserInput(TradeSide side) {

            dayTrader.sendMarketOrder(dayTrader.getInstrumentId(), side, FixedPointNumber.ONE);
//        trades.put(tradeId, tradeId + " " + side.name() + " " + FixedPointNumber.TEN + " - " + new Date());
    }

    @Override
    public String getTradeDetails(long orderId) {
        return trades.get(orderId);
    }
}
