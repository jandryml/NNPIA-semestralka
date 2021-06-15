import {useHistory, useParams} from "react-router";
import GenericDetail from "../reusables/GenericDetail";
import moment from "moment";

const TicketDetail = () => {
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

    const DetailLayout = ({item: ticket}) => {
        return (
            <div>
                {ticket && <div>
                    <h3>{ticket.program.film.name}</h3>
                    <p>Date: {moment(ticket.program.timestamp).format("Do MMMM YYYY, h:mm a")}</p>
                    <p>Username: {ticket.user.username}</p>
                    <p>Cinema: {item.program.hall.cinema.name}</p>
                    <p>Hall: {item.program.hall.name}</p>
                </div>}
            </div>);
    }

    return (
        <GenericDetail DetailLayout={DetailLayout} handleModify={handleModify} handleDelete={handleClick}
                       url={"http://localhost:8080/api/ticket/"}/>
    );
};

export default TicketDetail;
