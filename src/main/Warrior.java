public class Warrior extends Player
{
    protected int vigor;
    
    public Warrior (String name){
        super(name, 500)
    }

    @Override
    public void attack(Player target)
    {
        int damage = target.receiveDamage(15);
        System.out.println(this.getName() + " Atacou " + target.getName() + ", causando " + damage + " pontos de dano.");
        
        // Verificação pós-ataque, só para testes
        if (target.isAlive()) {
            System.out.println(
                target.getName() + " continua vivo (" +
                target.getCurrentHP() + "/" + target.getMaxHP() + " PV)."
            );
        } else {
           System.out.println(target.getName() + " Morreu!");
        }
    }
}