package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private long period = 10_000_000_000_000L;
    private StringBuilder processorVersion;
    private int valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    private Logger logger = Logger.getLogger(LocalProcessor.class.getName());

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap, Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = new StringBuilder(processorVersion);
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        try {
            stringArrayList.forEach(s -> System.out.println(s.hashCode()));
        }
        catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder sb = new StringBuilder(processorName);
        stringList.forEach(sb::append);
        return sb.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        }
        catch (Exception e) {
            logger.info(e.getMessage());
        }
        finally {
            informationScanner.close();
        }

    }
}
