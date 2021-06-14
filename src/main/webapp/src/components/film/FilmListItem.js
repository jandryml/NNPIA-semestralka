import {Link} from "react-router-dom";

const FilmListItem = ({item: film}) => {
    return (
        <div className="blog-preview" key={film.id}>
            <Link to={`/film/${film.id}`}>
                <h2>{film.name}</h2>
                <p>Language: {film.language}</p>
            </Link>
        </div>
    );
};

export default FilmListItem;