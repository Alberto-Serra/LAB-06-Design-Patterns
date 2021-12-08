public class RomulanClient extends AlienClient{

    public RomulanClient(OrderingStrategy strategy) {
        super(strategy);
    }

    @Override
    public OrderingStrategy createOrderingStrategy() {
        return new ImpatientStrategy();
    }
}
