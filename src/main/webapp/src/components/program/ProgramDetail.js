import {useHistory, useParams} from "react-router";
import GenericDetail from "../reusables/GenericDetail";
import moment from "moment";

const ProgramDetail = () => {
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

    const DetailLayout = ({item}) => {
        return (
            <div>
                {item && <div>
                    <h2>{item.film.name}</h2>
                    <p>Language: {item.film.language}</p>
                    <p>Duration: {item.film.durationMinute} minute(s)</p>
                    <p>Description: </p>
                    <div>{item.film.description}</div>
                    <p>Exact time: {moment(item.timestamp).format("Do MMMM YYYY, h:mm a")}</p>
                    <p>Cinema: {item.hall.cinema.name}</p>
                    <p>Hall: {item.hall.name}</p>

                </div>}
            </div>);
    }

    return (
        <GenericDetail DetailLayout={DetailLayout} handleModify={handleModify} handleDelete={handleClick}
                       url={"http://localhost:8080/api/program/"}/>
    );
};

export default ProgramDetail;
