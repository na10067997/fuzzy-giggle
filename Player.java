
public class Player
{

	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(final String setName)
	{
		this.name = setName;
	}

	public Player(final String setName)
	{
		this.name = setName;
	}

	public Player(final Player other)
	{
		this.name = other.name;
	}

}
