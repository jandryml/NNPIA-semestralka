import {useHistory, useParams} from "react-router";
import GenericDetail from "../reusables/GenericDetail";

const FilmDetail = () => {
    const {id} = useParams();
    const history = useHistory();

    const handleModify = () => {
        fetch("http://localhost:8000/film/" + id, {
            method: "DELETE",
        }).then(() => {
            history.push("/film");
        });
    };

    const handleClick = () => {
        fetch("http://localhost:8000/film/" + id, {
            method: "DELETE",
        }).then(() => {
            history.push("/film");
        });
    };

    const DetailLayout = ({item: film}) => {
        return (
            <div>
                {film && <div>
                    <h2>{film.name}</h2>
                    <p>Language: {film.language}</p>
                    <p>Duration: {film.durationMinute} minute(s)</p>
                    <p>Description: </p>
                    <div>{film.description}</div>
                </div>}
            </div>);
    }

    return (
        <GenericDetail DetailLayout={DetailLayout} handleModify={handleModify} handleDelete={handleClick}
                       url={"http://localhost:8080/api/film/"}/>
    );
};

export default FilmDetail;
