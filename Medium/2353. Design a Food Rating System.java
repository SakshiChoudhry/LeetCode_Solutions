import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Food implements Comparable<Food>
{
    String name;
    int rating;
    Food(String name,int rating)
    {
        this.name=name;
        this.rating=rating;
    }
    @Override
    public int compareTo(Food other)
    {
        if(rating==other.rating)
        {
            return name.compareTo(other.name);
        }
        return -1 *Integer.compare(rating,other.rating);
    }
}
class FoodRatings {
    Map<String,Integer> foodRating;
    Map<String,String> foodCuisine;
    Map<String, PriorityQueue<Food>> sortcuisine;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating=new HashMap<>();
        foodCuisine=new HashMap<>();
        sortcuisine=new HashMap<>();
        for(int i =0;i<foods.length;i++)
        {
            foodRating.put(foods[i],ratings[i]);
            foodCuisine.put(foods[i],cuisines[i]);
            sortcuisine.computeIfAbsent(cuisines[i],k->new PriorityQueue<>()).add(new Food(foods[i],ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food,newRating);
        String c=foodCuisine.get(food);
        sortcuisine.get(c).add(new Food(food,newRating));
    }

    public String highestRated(String cuisine) {
        Food highest=sortcuisine.get(cuisine).peek();
        while(foodRating.get(highest.name)!=highest.rating)
        {
            sortcuisine.get(cuisine).poll();
            highest=sortcuisine.get(cuisine).peek();
        }
        return highest.name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */