65. Valid Number
Hard

450

3337

Favorite

Share
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
class Solution {
    public boolean isNumber(String s) {
        s=s.trim();
        if(s==null||s.length()==0)
            return false;
        
        boolean hasE=false;
        boolean hasDot=false;
        boolean haspn=false;
        boolean hasDi=false;
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            switch(temp){
                case 'e':
                case 'E':
                    if(hasE||i==0||i==s.length()-1||!hasDi)return false;
                    else hasE=true;
                    break;
                case '.':
                    if (hasE||hasDot||s.length()==1||(i==0||!(Character.isDigit(s.charAt(i-1)))) && (i==s.length()-1||!Character.isDigit(s.charAt(i+1)))) return false;//重点 
                    //+.8 true//. false//.e false 34. false
                    else hasDot=true;
                    break;
                case '+':
                case '-':
                    if(i==s.length()-1||i!=0&&s.charAt(i-1)!='e') return false;
                    else haspn=true;
                    break;
                case ' ': 
                    return false;
                default:
                    if(Character.isLetter(temp)) return false;
                    if(Character.isDigit(temp)) hasDi=true;
            }
        }
        return true;
    }
}