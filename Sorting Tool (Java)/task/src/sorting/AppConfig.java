package sorting;

import com.beust.jcommander.Parameter;

public class AppConfig {
    @Parameter(names = {"-sortIntegers"}, description = "Indicates input numbers should be sorted")
    public boolean sortIntegers = false;

    @Parameter(names = {"-dataType"}, description = "Specifies how app should interpret input")
    public String dataType = "long";
}
