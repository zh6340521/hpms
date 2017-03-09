package hpms.fin.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;




public class Test {
	/**
     * 获取当前时间
     *
     * @param args
     */
	public static String getNowTime() throws ParseException {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        String lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
	/**
     * 判断当天是否为本月第一天
     *
     * @return
     */
	public static boolean isFirstDayOfMonth() throws ParseException {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dft.parse( "2017-03-02" );
        boolean flag = false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int today = calendar.get(calendar.DAY_OF_MONTH);
        if (1 == today) {
            flag = true;
        }
        return flag;
    }
	 /**
     * 获取当前月份最后一天
     *
     * @param date
     * @return
     * @throws ParseException
     */
	public static String getMaxMonthDate() throws ParseException {
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = dft.parse( "2017-03-02" );
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dft.format(calendar.getTime());
    }
	 /**
    *
    * 描述:获取下一个月的第一天.
    *
    * @return
	 * @throws ParseException 
    */
   public static String getPerFirstDayOfMonth() throws ParseException {
	   SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
       Calendar calendar = Calendar.getInstance();
       Date date = dft.parse( "2017-03-02" );
       calendar.setTime(date);
       calendar.add(Calendar.MONTH, 1);
       calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
       return dft.format(calendar.getTime());
   }

   /**
    *
    * 描述:获取上个月的最后一天.
    *
    * @return
    */
   public static String getLastMaxMonthDate() {
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(new Date());
       calendar.add(Calendar.MONTH, -1);
       calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
       return dft.format(calendar.getTime());
   }

   /**
    * 获取上一个月
    *
    * @return
    */
   public static String getLastMonth() {
       Calendar cal = Calendar.getInstance();
       cal.add(cal.MONTH, -1);
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
       String lastMonth = dft.format(cal.getTime());
       return lastMonth;
   }

   /**
    *
    * 描述:获取下一个月.
    *
    * @return
    */
   public static String getPreMonth() {
       Calendar cal = Calendar.getInstance();
       cal.add(cal.MONTH, 1);
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
       String preMonth = dft.format(cal.getTime());
       return preMonth;
   }


//是否是最后一天
   public static boolean isLastDayOfMonth() throws ParseException {
       boolean flag = false;
       if (StringUtils.isNotBlank(getNowTime()) && StringUtils.isNotBlank(getMaxMonthDate()) && StringUtils.equals(getNowTime(), getMaxMonthDate())) { // getMaxMonthDate().equals(getNowTime())
           flag = true;
       }
       return flag;
   }
   
   /**
    * 获取任意时间的下一个月
    * 描述:<描述函数实现的功能>.
    * @param repeatDate
    * @return
    */
   public static String getPreMonth(String repeatDate) {
       String lastMonth = "";
       Calendar cal = Calendar.getInstance();
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
       int year = Integer.parseInt(repeatDate.substring(0, 4));
       String monthsString = repeatDate.substring(4, 6);
       int month;
       if ("0".equals(monthsString.substring(0, 1))) {
           month = Integer.parseInt(monthsString.substring(1, 2));
       } else {
           month = Integer.parseInt(monthsString.substring(0, 2));
       }
       cal.set(year,month,Calendar.DATE);
       lastMonth = dft.format(cal.getTime());
       return lastMonth;
   }
   
   /**
    * 获取任意时间的上一个月
    * 描述:<描述函数实现的功能>.
    * @param repeatDate
    * @return
    */
   public static String getLastMonth(String repeatDate) {
       String lastMonth = "";
       Calendar cal = Calendar.getInstance();
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
       int year = Integer.parseInt(repeatDate.substring(0, 4));
       String monthsString = repeatDate.substring(4, 6);
       int month;
       if ("0".equals(monthsString.substring(0, 1))) {
           month = Integer.parseInt(monthsString.substring(1, 2));
       } else {
           month = Integer.parseInt(monthsString.substring(0, 2));
       }
       cal.set(year,month-2,Calendar.DATE);
       lastMonth = dft.format(cal.getTime());
       return lastMonth;
   }
    //
   /**
    * 获取任意时间的月的最后一天
    * 描述:<描述函数实现的功能>.
    * @param repeatDate
    * @return
    */
   private static String getMaxMonthDate(String repeatDate) {
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
       Calendar calendar = Calendar.getInstance();
       try {
           if(StringUtils.isNotBlank(repeatDate) && !"null".equals(repeatDate)){
               calendar.setTime(dft.parse(repeatDate));
           }
       } catch (ParseException e) {
           e.printStackTrace();
       }
       // calendar.add(Calendar.MONTH, -1);
       calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
       return dft.format(calendar.getTime());
   }
   
   /**
    * 获取任意时间的月第一天
    * 描述:<描述函数实现的功能>.
    * @param repeatDate
    * @return
    */
   private static String getMinMonthDate(String repeatDate){
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
       Calendar calendar = Calendar.getInstance();
       try {
           if(StringUtils.isNotBlank(repeatDate) && !"null".equals(repeatDate)){
               calendar.setTime(dft.parse(repeatDate));
           }
       } catch (ParseException e) {
           e.printStackTrace();
       }
       // calendar.add(Calendar.MONTH, -1);
       calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
      return dft.format(calendar.getTime());        

   }

/**
    * 不论是当前时间，还是历史时间  皆是时间点的前天

    * repeatDate  任意时间

    */
   public static String getModify2DaysAgo(String repeatDate) {
       Calendar cal = Calendar.getInstance();
       String daysAgo = "";
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
       if (repeatDate == null || "".equals(repeatDate)) {
           cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 2);

       } else {
           int year = Integer.parseInt(repeatDate.substring(0, 4));
           String monthsString = repeatDate.substring(4, 6);
           int month;
           if ("0".equals(monthsString.substring(0, 1))) {
               month = Integer.parseInt(monthsString.substring(1, 2));
           } else {
               month = Integer.parseInt(monthsString.substring(0, 2));
           }
           String dateString = repeatDate.substring(6, 8);
           int date;
           if ("0".equals(dateString.subSequence(0, 1))) {
               date = Integer.parseInt(dateString.substring(1, 2));
           } else {
               date = Integer.parseInt(dateString.substring(0, 2));
           }
           cal.set(year, month-1, date - 1);
           System.out.println(dft.format(cal.getTime()));
       }
       daysAgo = dft.format(cal.getTime());
       return daysAgo;
   }
   
   /**
    * 不论是当前时间，还是历史时间  皆是时间点的T-N天

   * repeatDate 任意时间    param 数字 可以表示前几天

    */
   public static String getModifyNumDaysAgo(String repeatDate,int param) {
       Calendar cal = Calendar.getInstance();
       String daysAgo = "";
       SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
       if (repeatDate == null || "".equals(repeatDate)) {
           cal.set(Calendar.DATE, cal.get(Calendar.DATE) - param);

       } else {
           int year = Integer.parseInt(repeatDate.substring(0, 4));
           String monthsString = repeatDate.substring(4, 6);
           int month;
           if ("0".equals(monthsString.substring(0, 1))) {
               month = Integer.parseInt(monthsString.substring(1, 2));
           } else {
               month = Integer.parseInt(monthsString.substring(0, 2));
           }
           String dateString = repeatDate.substring(6, 8);
           int date;
           if ("0".equals(dateString.subSequence(0, 1))) {
               date = Integer.parseInt(dateString.substring(1, 2));
           } else {
               date = Integer.parseInt(dateString.substring(0, 2));
           }
           cal.set(year, month-1, date - param+1);
           System.out.println(dft.format(cal.getTime()));
       }
       daysAgo = dft.format(cal.getTime());
       return daysAgo;
   }
   public static Long daysBetween(String smdate,String bdate) throws ParseException{  
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
       Calendar cal = Calendar.getInstance();    
       cal.setTime(sdf.parse(smdate));    
       long time1 = cal.getTimeInMillis();                 
       cal.setTime(sdf.parse(bdate));    
       long time2 = cal.getTimeInMillis();         
       long between_days=(time2-time1)/(1000*3600*24);  
           
      return Long.parseLong(String.valueOf(between_days));     
   }
   
   public static Long temp(String YYMM) throws ParseException{   
	   String strDate = YYMM;
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
	   Calendar calendar = Calendar.getInstance();   
	   Date date = sdf.parse(strDate); 
	   calendar.setTime(date);   
	   int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   
	   return Long.parseLong(String.valueOf(day));

	}
	public static void main(String[] args) throws ParseException {
		System.out.println(getNowTime());
		System.out.println(isFirstDayOfMonth());
		System.out.println(getMaxMonthDate());
		System.out.println(getPerFirstDayOfMonth());
		StringBuffer sb = new StringBuffer();
		sb.append("101,");
		System.out.println(sb.toString().substring(0, sb.toString().length()-1));
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date d1=sdf.parse("2012-09-08 10:10:10");  
        Date d2=sdf.parse("2012-09-15 00:00:00");  
        //System.out.println(daysBetween(d1,d2));  
*/  
        System.out.println(daysBetween("2012-09-08","2012-09-15"));
        System.out.println(temp("2012-09-08"));
        System.out.println((float)((Math.round(8.457)*100)/100));
        float price=(float)1.3333;
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p= decimalFormat.format(price);
        System.out.println(p);
        float   f   =   (float)34;  
        BigDecimal b = new BigDecimal(f);  
        float f1   =   b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue(); 
        System.out.println(f1);
        
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");

              String  formDate =sdf.format(date);

               System.out.println(formDate);

               String no = formDate.substring(10);

               System.out.println(no);
	}

}
