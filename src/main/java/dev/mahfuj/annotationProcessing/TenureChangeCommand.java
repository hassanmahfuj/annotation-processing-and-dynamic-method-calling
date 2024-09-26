package dev.mahfuj.annotationProcessing;

@CommandAttribute("TenureChangeCommand")
public class TenureChangeCommand extends Command<TenureChange> {

    public TenureChangeCommand(TenureChange tenureChange) {
        super(tenureChange);
    }

}
