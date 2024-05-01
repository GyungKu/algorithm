import java.util.HashMap;

class Solution {
    public Object[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) map.put(players[i], i);

        for (String s : callings) {
            Integer idx = map.get(s);
            if (idx > 0) {
                String tmp = players[idx-1];
                players[idx-1] = s;
                players[idx] = tmp;
                map.replace(s, idx-1);
                map.replace(tmp, idx);
            }
        }

        return players;
    }
}