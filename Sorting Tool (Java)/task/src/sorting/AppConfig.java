package sorting;

import com.beust.jcommander.Parameter;

public class AppConfig {
    @Parameter(names = {"-sortingType"}, description = "Specifies how input should be sorted")
    public String sortingType = "natural";

    @Parameter(names = {"-dataType"}, description = "Specifies how app should interpret input")
    public String dataType = "long";
}
