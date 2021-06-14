import { Link } from "react-router-dom";

const FilmList = ({ films, title }) => {
    return (
        <div className="blog-list">
            <h2>{title}</h2>
            {films.map((film) => (
                <div className="blog-preview" key={film.id}>
                    <Link to={`/film/${film.id}`}>
                        <h2>{film.name}</h2>
                        <p>Language: {film.language}</p>
                    </Link>
                </div>
            ))}
        </div>
    );
};

export default FilmList;