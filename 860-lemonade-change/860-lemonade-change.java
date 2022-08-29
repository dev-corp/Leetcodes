class Solution
{
    public boolean lemonadeChange(int[] bills) 
    {
        //HashMap<Integer, Integer> collections = new HashMap<>();
        int five = 0, ten = 0;
        for (int i : bills) 
        {
            if (i == 5) 
                five++;
            else if (i == 10) 
            {
                five--; 
                ten++;
            }
            else if (ten > 0)
            {
                ten--;
                five--;
            }
            else five -= 3;
            if (five < 0)
                return false;
        }
                return true;
    }
}

        
        // by Shubhi's logic
//         //iteration over arr for performing cashflow
//         for(int i=0;i<arr.length;i++)
//         {
//                 if(collections.containsKey(arr[i]))
//                 {
//                     Integer value = collections.get(arr[i]);
//                     collections.put(arr[i],(value + 1));
//                 }
//                 else
//                     collections.put(arr[i],1);
            
//             if(arr[i]>5)
//             {
//              Integer change = arr[i] - 5;   
//                 if(change == 5)
//                 {
//                     if(collections.containsKey(arr[i]))
//                     {
//                         Integer value = collections.get(5);
//                         collections.put(5,(value - 1));
//                     }
//                     else
//                         return false;
//                 }

//                 else
//                 {
//                     if( (collections.containsKey(5)) && (collections.containsKey(10)) )
//                         {
//                         Integer value_5 = collections.get(5);
//                         Integer value_10 = collections.get(10);
//                         collections.put(5,(value_5 - 1)); 
//                          collections.put(10,(value_10 - 1));    
//                         }
//                         else if( (collections.containsKey(5)))
//                         {
//                             if(collections.get(5) >= 3)
//                             {
//                                 Integer value_5 = collections.get(5);
//                                 collections.put(5,(value_5 - 3)); 
//                             }
//                         }
//                                 else
//                                 return false;
//                 }
                                
//             }
//         }
//         return true;
//     }
// }
            
//             if(arr[i] == 5)
//                 if(collections.containsKey(arr[i]))
//                 {
//                     Integer value = collections.get(5);
//                     collections.put(5,(value + 1));
//                 }
//                 else
//                     collections.put(5,1);
            
//             // whose give 10 and have to return 5
//             if(arr[i] == 10)
//             {
//                 // to check whether we can return 5 to customer or not
//                 if(collections.containsKey(5))
//                 {
//                     Integer value = collections.get(5);
//                     if(value > 0)
//                     {
//                         collections.put(5,(value - 1));
                        
//                         //adding value of 10 in hashmap
//                         if( collections.containsKey(10) )
//                             {
//                                 value = collections.get(10);
//                                 collections.put(10,(value + 1));
//                             }
//                             else
//                                 collections.put(10,1);
//                     }
                        
//                 }
//                 else
//                     return false;
//             }
            
//             if(arr[i] == 20)
//             {
//                 // to check we can return money through 3's 5 or not
//                 if(collections.containsKey(5))
//                 {
//                     Integer value = collections.get(5);
//                     if(value >= 3)
//                         collections.put(5,(value - 3));
//                         //adding value of 20 in hashmap is not needed since we do not need anywhere
//                 }
                
//                 // to check we can return money through 1's ten and 1's 5 or not
//                 else if( (collections.containsKey(5)) && (collections.containsKey(10)) )
//                         {
//                             Integer value_5 = collections.get(5);
//                             Integer value_10 = collections.get(10);
//                             if( (value_5 >= 1) && (value_10 >= 1) )
//                                {
//                                 collections.put(5, (value_5 - 1));
//                                 collections.put(10, (value_10 - 1));
//                                }
//                         }
//                 else
//                     return false;
//             }
//         }
        
//         return true;
//     }
// }