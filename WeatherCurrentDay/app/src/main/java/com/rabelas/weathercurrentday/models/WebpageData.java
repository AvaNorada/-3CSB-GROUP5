package com.rabelas.weathercurrentday.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebpageData {
    private String pageTitle;
    private String pageBody;

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageBody() {
        return pageBody;
    }

    public void setPageBody(String pageBody) {
        this.pageBody = pageBody;
    }

    public void extractText(String start, String end){
        int count = 1;
        StringBuffer sb= new StringBuffer();
        StringBuffer sbA;
        String form,temp="";
        String[] split;
        if (start.equals("After")){
            sbA= new StringBuffer();
            split= pageBody.split("After");
            sbA.append(split[1]);
            form =sbA.toString();
            split= form.split("\\. ");
            for(String s: split){
                sb.append(count+". "+s+".\n\n");

                count ++;
            }
            temp= sb.toString();
            setPageBody(temp);

        }else{

            String pattern=start+"(.*?)"+end;
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(pageBody);

            if (m.find( )) {
                split= m.group(1).split("\\. ");
                for(String s: split){
                    sb.append(count+". "+s+".\n\n");

                    count ++;
                }
                temp= sb.toString();
                setPageBody(temp);


            }else {
                setPageBody("NO MATCH");
            }//*/
        }

    }
}
