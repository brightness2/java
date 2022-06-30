package com;

public class Outer {
    private String name = "outer";

    // public void run(){
    //     Inner i = new Inner();
    //     System.out.println("outer name ="+i.getOuterName());
    //     System.out.println("inner name ="+i.getInnerName());

    // }

   public class Inner{
        protected String name = "inner";

        public String getOuterName(){
            return Outer.this.name;
        }

        public String getInnerName(){
            return name;
        }
    }

}
