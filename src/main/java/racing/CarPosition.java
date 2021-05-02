package racing;

public class CarPosition {
	private static final String ILLEGAL_POSITION_MESSAGE = "위치값은 0 이상의 자연수만 가능합니다.";
	private int position;

	public CarPosition(int position) {
		if (position < 0) {
			throw new IllegalArgumentException(ILLEGAL_POSITION_MESSAGE);
		}
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void increasePosition() {
		position++;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CarPosition carPosition = (CarPosition)obj;
		return this.position == carPosition.position;
	}
}
