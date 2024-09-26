package dev.mahfuj.annotationProcessing;

public class Main {

    public static void main(String[] args) {
        CommandProcessor processor = new CommandProcessor();

        TenureChange tenureChange = new TenureChange(12);
        processor.process(new TenureChangeCommand(tenureChange));

        ProfitRateChange ProfitRateChange = new ProfitRateChange(13);
        processor.process(new ProfitRateChangeCommand(ProfitRateChange));
    }

}