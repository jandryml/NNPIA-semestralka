import {useHistory, useParams} from "react-router";
import GenericDetail from "../reusables/GenericDetail";

const CinemaDetail = () => {
    const {id} = useParams();
    const history = useHistory();

    //TODO refactor functions
    const handleModify = () => {
        fetch("http://localhost:8000/cinema/" + id, {
            method: "DELETE",
        }).then(() => {
            history.push("/film");
        });
    };

    const handleClick = () => {
        fetch("http://localhost:8000/cinema/" + id, {
            method: "DELETE",
        }).then(() => {
            history.push("/film");
        });
    };

    const DetailLayout = ({item: cinema}) => {
        return (
            <div>
                {cinema && <div>
                    <h2>{cinema.name}</h2>
                    <p>Address: {cinema.address}</p>
                    <p>Email: {cinema.email}</p>
                    <p>Telephone: {cinema.telephone}</p>
                </div>}
            </div>);
    }

    return (
        <GenericDetail DetailLayout={DetailLayout} handleModify={handleModify} handleDelete={handleClick}
                       url={"http://localhost:8080/api/cinema/"}/>
    );
};

export default CinemaDetail;
