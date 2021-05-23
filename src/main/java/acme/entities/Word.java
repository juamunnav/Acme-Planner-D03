
package acme.entities;

import javax.persistence.Entity;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Word extends DomainEntity {

	public Word(final String word) {
		this.palabra = word;
	}

	public Word() {

	}

	@Override
	public String toString() {
		return this.palabra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.palabra == null) ? 0 : this.palabra.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final Word other = (Word) obj;
		if (this.palabra == null) {
			if (other.palabra != null)
				return false;
		} else if (!this.palabra.equals(other.palabra))
			return false;
		return true;
	}


	private static final long	serialVersionUID	= 1L;

	private String	palabra;

}
