import useFetch from "../../services/useFetch";
import FilmList from "./list/FilmList";

const FilmView = () => {
    const {data: films, isPending, error} = useFetch('http://localhost:8080/api/film');

    return (
        <div className="home">
            {error && <div>{error}</div>}
            {isPending && <div>Loading...</div>}
            {films && <FilmList films={films} title="All Films"/>}
        </div>
    );
};

export default FilmView;
