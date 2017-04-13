package ${class.packageName};
 
class ${class.name} {
 
<#list aKeys as attrName>
    private ${attributeSet[attrName]} ${attrName};
</#list>

<#list aKeys as attrName>
    public ${attributeSet[attrName]} get${attrName?cap_first}(){
        return this.${attrName};
    }
 
    public void set${attrName?cap_first}(${attributeSet[attrName]} ${attrName}){
        return this.${attrName} = ${attrName};
    }
 
</#list>
}