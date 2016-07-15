/**
 * Created by yjb on 16-7-14.
 */
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

import java.io.File;
import java.util.List;

public class demo {
    public static void main(String agrs[]){
        String serializedClassifier = "classifiers/english.muc.7class.distsim.crf.ser.gz";
        CRFClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);

        String str1 = "Cancer ACT FAM126A ACOT7 To analyze the prognostic factors of 5-year survival and 10-year survival in hepatocellular carcinoma  patients, and to explore the reasons for long-term survival and provide choice of treatment modalities for HCC\n";
        List<List<CoreLabel>> out = classifier.classify(str1);
        for (List<CoreLabel> sentence : out){
            for (CoreLabel word : sentence) {
                System.out.println(word.word() + '/' + word.get(CoreAnnotations.AnswerAnnotation.class));
            }
            System.out.println();
        }

//        String str2 = classifier.classifyWithInlineXML(str1);
//        System.out.println(str2);
    }
}
