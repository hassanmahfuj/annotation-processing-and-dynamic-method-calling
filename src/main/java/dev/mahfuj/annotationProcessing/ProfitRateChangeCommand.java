package dev.mahfuj.annotationProcessing;

@CommandAttribute("ProfitRateChangeCommand")
public class ProfitRateChangeCommand extends Command<ProfitRateChange> {

    public ProfitRateChangeCommand(ProfitRateChange profitRateChange) {
        super(profitRateChange);
    }

}
