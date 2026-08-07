class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0) return "empty";

        return strs.stream()
        .map(r->"."+r)
        .collect(Collectors.joining("-"));
    }

    public List<String> decode(String str) {
        if("empty".equals(str)) return List.of();
        
        String[] splited = str.split("-");

        return Arrays.asList(splited).stream().map(r->r.substring(1)).toList();

    }
}
