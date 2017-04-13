
public class ${name} {

    public void test(){
<#list countries as country>
    String x${country_index + 1} = "${country}";
</#list>        
    }

}