package Arrays;

import java.util.HashMap;

/*
In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class FindtheTownJudge {
    public static int findJudge1(int n, int[][] trust) {
        int[] trusts=new int[n];
        int[] trusted=new int[n];
        for(int[] t:trust){
            trusts[t[0]-1]++;
            trusted[t[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(trusts[i]==0 && trusted[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
    public static int findJudge2(int n, int[][] trust) {
        int[] count=new int[n];
        for(int[] t:trust){
            count[t[0]-1]--;
            count[t[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(count[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] trust1={{1,2}},trust2= {{1,3},{2,3}},trust3={{1,3},{2,3},{3,1}};
        int n1=2,n2=3,n3=3;
        System.out.println(findJudge1(n1,trust1));//2
        System.out.println(findJudge1(n2,trust2));//3
        System.out.println(findJudge1(n3,trust3));//-1
        System.out.println(findJudge2(n1,trust1));//2
        System.out.println(findJudge2(n2,trust2));//3
        System.out.println(findJudge2(n3,trust3));//-1

    }
}
