public class TestA3 {
  
 
  public static void main(String[] args) { 
    World w = new World();
    w.addClan(new Clan("Settlers",6));
    w.addClan(new Clan("Raiders",5));
    w.addClan(new Clan("Hordes",7));
    System.out.println(w);
    while(w.getNumClans()>1){
      randomAttack(w);
      System.out.println(w);
    }
    System.out.println("Game Over.");
  }
  
  public static void randomAttack(World w){
    int n = w.getNumClans();
    int clan1 = (int)(n*Math.random());
    int clan2 = (int)(n*Math.random());
    if(clan1==clan2)
      clan2 = (clan2+1+(int)((n-1)*Math.random()))%n;
    w.attack(clan1,clan2);
  }
  
}
