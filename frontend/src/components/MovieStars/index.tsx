import { ReactComponent as StarEmpty } from "assets/img/star-empty.svg";
import { ReactComponent as StarFull } from "assets/img/star-full.svg";
import { ReactComponent as StarHalf } from "assets/img/star-half.svg";

import "./styles.css";

type Props = {
  score: number;
};

// EX:
// getFills(3.5) => [1, 1, 1, 0.5, 0]
// getFills(4.1) => [1, 1, 1, 1, 0.5]
function getFills(score: number) {
  const fills = [0, 0, 0, 0, 0];

  const integerPart = Math.floor(score);

  for (let i = 0; i < integerPart; i++) {
    fills[i] = 1;
  }

  const diff = score - integerPart;
  if (diff > 0) {
    fills[integerPart] = 0.5;
  }

  return fills;
}

function MovieStars({ score }: Props) {
  return (
    <div className="dsmovie-stars-container">
      {getFills(score).map((fill) => {
        if (fill === 1) return <StarFull />;
        if (fill === 0.5) return <StarHalf />;
        return <StarEmpty />;
      })}
    </div>
  );
}

export default MovieStars;
