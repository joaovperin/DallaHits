
public class ${name} {

    public void test(){
<#list tables as ta>
    String x = "${ta}";
</#list>
    }

}