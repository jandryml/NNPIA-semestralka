import {useParams} from "react-router";
import useFetch from "../../hooks/useFetch";

const GenericDetail = ({DetailLayout, handleModify, handleDelete, url}) => {
    const {id} = useParams();

    const {data, error, isPending} = useFetch(url + id);

    return (
        <div className="blog-details">
            {isPending && <div>Loading...</div>}
            {error && <div>{error}</div>}
            {data &&
            <article>
                <DetailLayout item={data}/>
                <button onClick={handleModify}>modify</button>
                <button onClick={handleDelete}>delete</button>
                <button>back</button>
            </article>
            }
        </div>
    );
};

export default GenericDetail;