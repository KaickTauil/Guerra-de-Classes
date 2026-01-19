import java.util.*
;
public abstract class Player {
    protected final String name;
    protected final int maxHP;
    protected int currentHP;

    public Player (String name, int maxHP) {
        if (maxHP <= 0)
            throw new IllegalArgumentException("Os PV precisam ser positivos!");
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public abstract void attack(Player target);

    public int receiveDamage(int damage) {
        if (damage <= 0)
            return 0;
        currentHP -= damage;
        if (currentHP <= 0)
            currentHP = 0;
        return damage;
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    private Map<Class<? extends Resource>, Resource> resources = new HashMap<>();

    // Associa o recurso a um valor ao instanciar, por addResource(new Mana(100)).
    // Talvez seja mais escalável assim, não sei ainda.
    public void addResource(Resource resource) {
        resources.put(resource.getClass(), resource);
    }

    // Isso deve funcionar como  o retorno de uma referência para um objeto do tipo Resource ou subclasses
    // Tecnicamente dá pra usar pra pegar valores de um recurso depois dele ser adicionado a um Job, é meio que um acesso dinâmico
    // O compilador fica chiando sem a anotação
    @SuppressWarnings("unchecked")
    public <T extends Resource> T getResource(Class<T> type) {
        return (T) resources.get(type);
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }
}