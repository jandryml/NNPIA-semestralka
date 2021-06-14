import {useHistory, useParams} from "react-router";
import useFetch from "../../../services/useFetch";

const FilmDetail = () => {
    const {id} = useParams();

    const {data: film, error, isPending,} = useFetch("http://localhost:8080/api/film/" + id);
    const history = useHistory();

    const handleClick = () => {
        fetch("http://localhost:8000/film/" + film.id, {
            method: "DELETE",
        }).then(() => {
            history.push("/film");
        });
    };

    return (
        <div className="blog-details">
            {isPending && <div>Loading...</div>}
            {error && <div>{error}</div>}
            {film && (
                <article>
                    <h2>{film.name}</h2>
                    <p>Language: {film.language}</p>
                    <p>Duration: {film.durationMinute} minute(s)</p>
                    <p>Description: </p>
                    <div>{film.description}</div>
                    {/*TODO add change film for moderator*/}
                    {/*<button onClick={handleClick}>modify</button>*/}
                    <button>modify</button>
                    <button>delete</button>
                    <button>back</button>
                </article>
            )}
        </div>
    );
};

export default FilmDetail;
