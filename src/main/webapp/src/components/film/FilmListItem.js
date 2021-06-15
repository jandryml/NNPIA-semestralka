import {Link} from "react-router-dom";

const FilmListItem = ({item: film, key}) => {
    return (
        <div className="blog-preview" key={key}>
            <Link to={`/film/${film.id}`}>
                <h2>{film.name}</h2>
                <p>Language: {film.language}</p>
            </Link>
        </div>
    );
};

export default FilmListItem;