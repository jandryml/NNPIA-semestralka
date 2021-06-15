import {Link} from "react-router-dom";
import moment from "moment";

const TicketListItem = ({item: ticket, listKey}) => {
    return (
        <div className="blog-preview" key={listKey}>
            <Link to={`/ticket/${ticket.id}`}>
                <h3>{ticket.program.film.name}</h3>
                <p>Date: {moment(ticket.program.timestamp).format("Do MMMM YYYY, h:mm a")}</p>
                <p>Username: {ticket.user.username}</p>
            </Link>
        </div>
    );
};

export default TicketListItem;