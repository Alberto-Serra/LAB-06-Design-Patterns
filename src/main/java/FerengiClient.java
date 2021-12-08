public class FerengiClient extends AlienClient{

    public FerengiClient(OrderingStrategy strategy) {
        super(strategy);
    }

    @Override
    public OrderingStrategy createOrderingStrategy() {
        return new SmartStrategy();
    }
}
