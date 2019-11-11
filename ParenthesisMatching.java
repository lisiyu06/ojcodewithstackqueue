package homework19;

import java.util.Stack;

/**
 * Author: lisiyu
 * Created: 2019/11/11
 */

// 括号匹配问题
// 力扣 20 ----- 有效的括号
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//    有效字符串需满足：
//	     左括号必须用相同类型的右括号闭合。
//	     左括号必须以正确的顺序闭合。
//       注意空字符串可被认为是有效字符串。

public class ParenthesisMatching {
    public boolean isValid(String s) {
        // 1. 创建一个栈
        Stack<Character>  stack = new Stack<>();
        // 2. 循环遍历每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 3. 如果是左括号，那就入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            // 4. 如果是右括号
            if (stack.isEmpty()) {
                return false;
            }
            char top = stack.pop();
            // 5. 检查栈顶元素和当前元素是否匹配
            if (top == '(' && c == ')') {
                continue;
            }
            if (top == '[' && c == ']') {
                continue;
            }
            if (top == '{' && c == '}') {
                continue;
            }
            // 如果代码走到这, 说明三种合法情况都不满足, 就是非法字符串
            return false;
        } // end for
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
