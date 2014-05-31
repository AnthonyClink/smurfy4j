smurfy4j
========

A tiny little idea I had using smurfys excellent mechwarrior data api

This is a java based client to interact with smurfy. It is designed to be ran in guice or spring but I will support more ioc containers if I am not the only user of this library.

To utilize the base features (at least the ones that I feel are complete) simply call the SmurfyService singleton.

Smurfy has indexed the mechs, and the first mech indexed is the hunchback. So lets see how we utilize the api.

```
    my-app.java
    public static void main(String[] args){
        SmurfyService smurfyService = SmurfyService.getInstance();
        
        Mech mech = smurfyService.getStockMech(1);
        
        System.out.println(mech.getName()) //prints hbk-4g
        
        System.out.println(mech.getConfiguration().get(0).name); //prints "head"
        System.out.println(mech.getConfiguration().get(0).getItems().get(0).getName(); //prints "SMALL LASER"
    }
```

coming soon are additional api features utilizing your personal mech bay.

To see how this funtionality is used, see the tests in the application source.
