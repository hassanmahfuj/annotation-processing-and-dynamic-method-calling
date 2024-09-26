package dev.mahfuj.annotationProcessing;

@Aggregate
public class CommandHandlerAggregate {

    @CommandHandler
    public void tenureChangeHandler(TenureChangeCommand tenureChangeCommand) {
        System.out.println(tenureChangeCommand.getPayload().getTenure());
    }

    @CommandHandler
    public void profitRateChangeHandler(ProfitRateChangeCommand profitRateChangeCommand) {
        System.out.println(profitRateChangeCommand.getPayload().getProfitRate());
    }

}
