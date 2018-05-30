import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa941 on 2018/5/30.
 * 排序 collections.sort()
 */
public class MergeIntervals {
    private class myComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start < o2.start){
                return -1;
            }
            else if(o1.start > o2.start){
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        Collections.sort(intervals,new myComparator());
        for(Interval e : intervals){
            if(result.isEmpty()){
                result.add(e);
            }
            else {
                Interval x = result.get(result.size()-1);
                if(e.start > x.end){
                    result.add(e);
                }
                else if(e.start >= x.start && e.start <= x.end){
                    x.end  = Math.max(x.end,e.end);
                }
            }
        }
        return result;
    }
}
class Interval{
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(int s, int e){
        start = s;
        end = e;
    }
}