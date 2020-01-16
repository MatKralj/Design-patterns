package mkralj_zadaca_3.fileDataLoaders;

public class FileDataLoaderFactory {
    
    public FileDataLoader getTheRightLoader(String option, String url){
        switch(option.toLowerCase()){
            case "-u":
                return new UlogeDataLoader(url);
            case "-t":
                return new ProgramiDataLoader(url);
            case "-o":
                return new OsobeDataLoader(url);
            case "-e":
                return new EmisijeDataLoader(url);
            case "-v":
                return new VrstaEmisijeDataLoader(url);
        }
        
        return null;
    }
}
