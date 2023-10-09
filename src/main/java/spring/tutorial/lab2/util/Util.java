package spring.tutorial.lab2.util;

import org.springframework.util.comparator.Comparators;
import spring.tutorial.lab2.model.Role;

import java.util.Comparator;
import java.util.List;

public class Util {
    public static boolean compareArray(List<Role> a1, List<Role> a2){
        if(a1.size()>a2.size()) return false;
        int dem = 0 ;
        for(int i=0;i<a1.size();i++){
            for(int j=0;j<a2.size();j++){
                if(a1.get(i).getId()==a2.get(j).getId()){
                    dem++;
                }
            }
        }
        if(dem == a1.size()) return true;
        return false;

    }
}
