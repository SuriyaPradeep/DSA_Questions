package Arrays;

import java.util.Arrays;

/*
You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer array tokens, where each tokens[i] donates the value of tokeni.

Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an unplayed token in one of the two ways (but not both for the same token):

Face-up: If your current power is at least tokens[i], you may play token[i], losing tokens[i] power and gaining 1 score.
Face-down: If your current score is at least 1, you may play token[i], gaining tokens[i] power and losing 1 score.
Return the maximum possible score you can achieve after playing any number of tokens.
 */
public class BagofTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length,res=0,p=0,left=0,right=n-1;
        while (left<=right){
            if(power>=tokens[left]){
                power-=tokens[left++];
                p++;
                res=Math.max(res,p);
            }else if(p>0){
                power+=tokens[right--];
                p--;
            }else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1={100},arr2={200,100},arr3={100,200,300,400};
        int p1=50,p2=150,p3=200;
        System.out.println(bagOfTokensScore(arr1,p1));//0
        System.out.println(bagOfTokensScore(arr2,p2));//1
        System.out.println(bagOfTokensScore(arr3,p3));//2
    }
}
