import {useHistory, useParams} from "react-router";
import GenericDetail from "../reusables/GenericDetail";
import CinemaForm from "./CinemaForm";
import CinemaDataService from "../../services/api/CinemaDataService";
import HallView from "../hall/HallView";

const CinemaDetail = () => {
    const {id} = useParams();
    const history = useHistory();

    const handleDelete = () => {
        console.log("removing cinema detail")
        CinemaDataService.remove(id).then(() => {
            history.push("/cinema");
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
        <GenericDetail DetailLayout={DetailLayout} DetailForm={CinemaForm} AdditionalLayout={HallView} handleDelete={handleDelete}
                       url={"http://localhost:8080/api/cinema/"}/>
    );
};

export default CinemaDetail;
